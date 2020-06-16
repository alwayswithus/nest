package com.douzone.nest.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.nest.dto.JsonResult;
import com.douzone.nest.service.CommentService;
import com.douzone.nest.vo.CommentLikeUserVo;
import com.douzone.nest.vo.CommentVo;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	private final SimpMessagingTemplate template;

	@Autowired
	public CommentController(SimpMessagingTemplate template) {
		this.template = template;
	}
	
	/*
	 * 작성자 : 김우경
	 * comment insert
	 */
	@PostMapping("/api/comment")
	public JsonResult comment(
			@RequestBody CommentVo commentVo) {    
		boolean result = commentService.insertComment(commentVo);

		return JsonResult.success(result ? commentVo : -1);
	}

	/*
	 * 작성자 : 김우경
	 * comment update
	 */
	@PostMapping("/api/comment/contents/{commentNo}")
	public JsonResult commentUpdate(
			@PathVariable("commentNo") Long commentNo,
			@RequestBody CommentVo commentVo) {

		boolean result = commentService.updateCommentContents(commentNo, commentVo);

		return JsonResult.success(result ? commentVo.getCommentContents() : -1);

	}

	/*
	 * 작성자 : 김우경
	 * comment like update
	 */
	@PostMapping("/api/comment/like/{commentNo}")
	public JsonResult commentLikeUpdate(
			@PathVariable("commentNo") Long commentNo,
			@RequestBody CommentVo commentVo,
			ModelMap modelMap) {

		CommentLikeUserVo likeUser = commentService.selectLikeUser(commentVo.getUserNo(), commentNo);

		modelMap.putAll(commentService.updateCommentLike(likeUser, commentVo.getUserNo(), commentNo, commentVo.getCommentLike()));

		return JsonResult.success((boolean) modelMap.get("result") ? modelMap.get("commentLike") : -1);
	}

	/*
	 * 작성자 : 김우경
	 * comment delete
	 */
	@PostMapping("/api/comment/{commentNo}/{fileNo}")
	public JsonResult commentDelete(
			@PathVariable("commentNo") Long commentNo,
			@PathVariable("fileNo") Long fileNo) {

		boolean result = commentService.deleteComment(fileNo, commentNo);
		return JsonResult.success(result ? commentNo : -1);
	}

	@MessageMapping("/all") // react -> spring 송신
//	@SendTo("/topic/all")	// spring -> react 송신
	public void send(Map<Object, Object> socketData) {
		System.out.println(socketData);
		template.convertAndSend("/topic/all", socketData);
	}
}
