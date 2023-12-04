package com.agridence.microservice.Assignment.Controller;

import com.agridence.microservice.Assignment.DTO.NoteDTO;
import com.agridence.microservice.Assignment.Service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class NoteController
{
	private final NoteService noteService;

	@GetMapping("/note/{id}")
	public ResponseEntity<NoteDTO> getNote(@PathVariable long id, @RequestHeader("Authorization") String token)
	{
		NoteDTO note = noteService.getNote(id, token);
		return ResponseEntity.ok(note);
	}
	@PostMapping("/note")
	public ResponseEntity<String> createNote(@RequestBody @Valid NoteDTO noteDTO,
											 @RequestHeader("Authorization") String token)
	{
		long noteID = noteService.createNote(noteDTO,token);
		String uriString = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(noteID)
				.toUriString();
		System.out.println("Note URI: " + uriString);
		return ResponseEntity.created(URI.create(uriString)).body(uriString);
	}
	@DeleteMapping("/note/{id}")
	public ResponseEntity<Object> deleteNote(@PathVariable long id,
											 @RequestHeader("Authorization") String token)
	{
		noteService.deleteNote(id, token);
		return ResponseEntity.ok("Note Deleted Successfully");
	}
}
