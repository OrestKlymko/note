package com.example.crudCommand;


import com.example.entity.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class NoteService {
	private List<Note> list = new ArrayList<>();

	public List<Note> listAll() {
		return list;
	}

	private long generateId(){
		long leftLimit = 1L;
		long rightLimit = 10L;
		return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	}

	public Note add(Note note) {
		Note newNote = new Note();
		newNote.setId(generateId());
		newNote.setTitle(note.getTitle());
		newNote.setContent(note.getContent());
		list.add(note);
		return note;
	}

	public void deleteById(long id) {
		try {
			list = list.stream().filter(note -> note.getId() != id).collect(Collectors.toList());
		} catch (Exception e) {
			throw new RuntimeException("Note not found");
		}
	}

	public void update(Note note) {
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == note.getId()) {
				list.set(i, note);
				flag=true;
			}
		}
		if(!flag) throw new RuntimeException("Note not found");
	}

	public Note getById(long id) {
		try {
			return list.stream().filter(note -> note.getId() == id).limit(1).toList().get(0);
		} catch (Exception e) {
			throw new RuntimeException("Note not found");
		}
	}
}
