package com.example.controller;


import com.example.crudCommand.NoteService;
import com.example.entity.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView editNote(@RequestParam("id") String id) {
		ModelAndView modelAndView = new ModelAndView("edit-note");
		modelAndView.addObject("noteEdit", noteService.getById(Long.parseLong(id)));
		return modelAndView;
	}

	@PostMapping("/create")
	public ModelAndView createNote(@RequestParam("title") String title, @RequestParam("content") String content) {
		Note note = new Note();
		note.setTitle(title);
		note.setContent(content);
		noteService.add(note);
		return new ModelAndView("redirect:/note/list");
	}

	@PostMapping("/edit")
	public ModelAndView completeEditNote(@RequestParam String id, String title, String content) {
		System.out.println(id);
		System.out.println(title);
		System.out.println(content);
		Note byId = noteService.getById(Long.parseLong(id));
		byId.setTitle(title);
		byId.setContent(content);
		noteService.update(byId);
		return new ModelAndView("redirect:/note/list");
	}

	@PostMapping("/delete")
	public ModelAndView deleteNote(@RequestParam String id) {
		noteService.deleteById(Long.parseLong(id));
		return new ModelAndView("redirect:/note/list");
	}
}