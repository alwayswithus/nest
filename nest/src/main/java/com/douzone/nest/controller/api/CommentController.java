package com.douzone.nest.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
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
    * comment like update
    */
	@PostMapping("/api/comment/{commentNo}")
	public JsonResult commentUpdate(
			@PathVariable("commentNo") Long commentNo,
			@RequestBody CommentVo commentVo) {
		
		
		System.out.println(commentVo.getUserNo());
		boolean result = commentService.updateComment(commentNo, commentVo);
		
		CommentLikeUserVo likeUser = commentService.selectLikeUser(commentVo.getUserNo(), commentNo);
		
		System.out.println(likeUser);

		if(commentVo.getCommentContents() != null) {
			//comment contents 업데이트
			return JsonResult.success(result ? commentVo.getCommentContents() : -1);
		} else {
			//comment like 업데이트
			if(likeUser == null) {
				// 좋아요 증가하기
				commentService.insertLikeUser(commentVo.getUserNo(), commentNo);
				return JsonResult.success(result ? commentVo.getCommentLike()+1 : -1);
			} else {
				commentService.deleteLikeUser(commentVo.getUserNo(), commentNo);
			}
		}
//		return JsonResult.success(null);
	}
	
	 	/*
	    * 작성자 : 김우경
	    * comment delete
	    */
		@DeleteMapping("/api/comment/{commentNo}/{fileNo}")
		public JsonResult commentDelete(
				@PathVariable("commentNo") Long commentNo,
				@PathVariable("fileNo") Long fileNo) {
			
			boolean result = commentService.deleteComment(fileNo, commentNo);
			return JsonResult.success(result ? commentNo : -1);
		}
}
