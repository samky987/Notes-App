package com.agridence.microservice.Assignment.Service;

import com.agridence.microservice.Assignment.DTO.NoteDTO;
import com.agridence.microservice.Assignment.Model.Note;
import com.agridence.microservice.Assignment.Model.User;
import com.agridence.microservice.Assignment.Repository.UserRepository;
import com.agridence.microservice.Assignment.Security.JwtUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class NoteService
{
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final JwtUtils jwtUtils;
    public NoteDTO getNote(long noteID, String token)
    {
        Optional<User> optionalUser = userRepository.findByUsername(jwtUtils.getUserNameFromJwtToken(token));
        User user = optionalUser.orElseThrow(() -> new EntityNotFoundException("User not found"));
        Note note = user.getNotes().get((int)noteID);
        return this.modelMapper.map(note, NoteDTO.class);
    }
    public void deleteNote(long noteID, String token)
    {
        Optional<User> optionalUser = userRepository.findByUsername(jwtUtils.getUserNameFromJwtToken(token));
        User user = optionalUser.orElseThrow(() -> new EntityNotFoundException("User not found"));
        System.out.println("Deleted Note: " + user.getNotes().get((int)noteID).getTitle());
        user.getNotes().remove((int)noteID);
        user.getNotes().forEach(e -> System.out.println(e.getTitle()));
        userRepository.save(user);
    }
    public long createNote(NoteDTO noteDTO, String token)
    {
        Optional<User> optionalUser = userRepository.findByUsername(jwtUtils.getUserNameFromJwtToken(token));
        User user = optionalUser.orElseThrow(() -> new EntityNotFoundException("User not found"));
        Note mappedNote = this.modelMapper.map(noteDTO, Note.class);
        List<Note> notes = user.getNotes();
        notes.add(mappedNote);
        userRepository.save(user);
        return notes.size() - 1 ;
    }
}
