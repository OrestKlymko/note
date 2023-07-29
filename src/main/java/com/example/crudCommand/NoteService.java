package com.example.crudCommand;


import com.example.entity.Note;
import com.example.repo.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
@RequiredArgsConstructor
public class NoteService {
	private final NoteRepository noteRepository;

	public List<Note> listAll() {
		return noteRepository.findAll();
	}


	public Note add(Note note) {
		return noteRepository.save(note);
	}

	public void deleteById(long id) {
		try {
			noteRepository.deleteById((int) id);
		} catch (Exception e) {
			throw new RuntimeException("Note not found");
		}
	}

	public void update(Note note) {
		noteRepository.save(note);
	}

	public Note getById(long id) {
		try {
			return noteRepository.getReferenceById((int) id);
		} catch (Exception e) {
			throw new RuntimeException("Note not found");
		}
	}
}
