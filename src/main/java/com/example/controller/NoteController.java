package com.example.controller;


import com.example.crudCommand.NoteService;
import com.example.entity.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/note")
public class NoteController {
	private final NoteService noteService;

	@GetMapping("/list")
	public ModelAndView getAllNotes() {
		ModelAndView modelAndView = new ModelAndView("list-note");
		modelAndView.addObject("listNotes", noteService.listAll());
		return modelAndView;
	}

	@GetMapping("/edit")
	public ModelAndView editNote(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView("edit-note");
		modelAndView.addObject("noteEdit", noteService.getById(Long.parseLong(id)));
		return modelAndView;
	}

	@PostMapping("/create")
	public ModelAndView createNote(Note note) {
		noteService.add(note);
		return new ModelAndView("redirect:/note/list");
	}

	@PostMapping("/edit")
	public ModelAndView completeEditNote(Note note) {
		noteService.update(note);
		return new ModelAndView("redirect:/note/list");
	}

	@PostMapping("/delete")
	public ModelAndView deleteNote(@RequestParam String id) {
		noteService.deleteById(Long.parseLong(id));
		return new ModelAndView("redirect:/note/list");
	}
}
