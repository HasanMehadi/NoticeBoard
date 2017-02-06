package com.NoticeBoard.org.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.NoticeBoard.org.Entity.Board;
import com.NoticeBoard.org.Repository.BoardRepository;
import com.NoticeBoard.org.ValidationCheck.RegistrationForm;

@Controller
public class BoardController {

	private static Logger LOGGER = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardRepository boardRepository;

	@RequestMapping(value = "/{boardName}", method = RequestMethod.GET)
	public String showBoard(@PathVariable("boardName") String boardName, Model model) {

		LOGGER.debug("Rendering Board Controller " + boardName);

		Board board = boardRepository.findByName(boardName);
		
		if(board==null){
			LOGGER.debug("No Board Found");
			model.addAttribute("boardName", boardName);
			return "newBoard";
		}
		
		model.addAttribute("boardName", boardName);
		model.addAttribute("content", board.getContent());
		return "Board";
	}
	
	@RequestMapping(value="/{register}",method=RequestMethod.POST)
	public String registerBoard(@Valid RegistrationForm registrationForm,BindingResult result, WebRequest request, RedirectAttributes redirectAttributes){
		
		System.out.println(request.getParameter("boardName"));
		System.out.println(request.getParameter("password"));
		
		if( result.hasErrors() ) {
			System.out.println(result.getAllErrors());
			redirectAttributes.addAttribute("error", "Password should be more than 3 characters and less than 250");
			return "redirect:/" + request.getParameter("boardName");
		}

		Board board = new Board();
		
		board.setName(request.getParameter("boardName"));
		board.setPassword(request.getParameter("password"));
		
		boardRepository.save(board);
		return "redirect:/" + request.getParameter("boardName");
	}
}
