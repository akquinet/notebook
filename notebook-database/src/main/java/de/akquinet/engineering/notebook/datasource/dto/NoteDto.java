package de.akquinet.engineering.notebook.datasource.dto;

import de.akquinet.engineering.notebook.datasource.entity.Note;
import de.akquinet.engineering.notebook.datasource.util.DateTimeConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Axel Meier, akquinet engineering GmbH
 */
public class NoteDto
{
    private Long id;
    
    private String title;

    private String description;

    private LocalDateTime time;

    public NoteDto()
    {

    }

    public NoteDto(final Long id, final String title,
                   final String description, final LocalDateTime time)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.time = time;
    }

    public NoteDto(final Note note)
    {
        this(note.getId(), note.getTitle(), note.getDescription(), note.getTime());
    }

    public NoteDto(final Long id, final String title,
                   final String description, final Date time)
    {
        this(id, title, description, DateTimeConverter.toLocalDateTime(time));
    }

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public LocalDateTime getTime()
    {
        return time;
    }

    public void setTime(final LocalDateTime time)
    {
        this.time = time;
    }

    @Override
    public String toString()
    {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                '}';
    }
}
