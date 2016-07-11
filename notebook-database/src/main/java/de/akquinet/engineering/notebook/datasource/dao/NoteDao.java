package de.akquinet.engineering.notebook.datasource.dao;

import de.akquinet.engineering.notebook.datasource.dto.NoteDto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Axel Meier, akquinet engineering GmbH
 */
public interface NoteDao
{
    List<NoteDto> getNotes(String userId);

    int getNoteCount(String userId);

    void deleteNote(NoteDto note, String userId);

    NoteDto updateNote(NoteDto note, String userId);

    List<NoteDto> getNotesSortedByDateAscNotThan(String userId, LocalDateTime localDateTime);

    NoteDto findNoteById(long id, String userId);
}
