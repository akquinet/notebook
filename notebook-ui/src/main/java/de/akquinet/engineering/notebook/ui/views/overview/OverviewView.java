package de.akquinet.engineering.notebook.ui.views.overview;

import de.akquinet.engineering.notebook.ui.View;
import de.akquinet.engineering.notebook.ui.model.NoteDto;

import java.util.Collection;

/**
 * @author Axel Meier, akquinet engineering GmbH
 */
public interface OverviewView extends View
{
    void setObserver(Observer observer);

    void selectNote(final NoteDto note);

    void setNotes(Collection<NoteDto> notes);

    void setEditorView(de.akquinet.engineering.notebook.ui.View view);

    void setEditorVisible(boolean visible);

    interface Observer {
        void onSelect(NoteDto selectedNote);

        void onAdd();

        void onDelete(NoteDto note);
    }
}
