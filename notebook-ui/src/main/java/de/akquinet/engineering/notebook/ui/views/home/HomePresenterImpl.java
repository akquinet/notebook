package de.akquinet.engineering.notebook.ui.views.home;

import com.vaadin.cdi.UIScoped;
import de.akquinet.engineering.notebook.ui.model.NoteDto;
import de.akquinet.engineering.notebook.ui.View;
import de.akquinet.engineering.notebook.ui.model.NoteModel;
import de.akquinet.engineering.notebook.ui.views.noteform.NoteFormPresenter;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Axel Meier, akquinet engineering GmbH
 */
@UIScoped
public class HomePresenterImpl implements HomePresenter, HomeView.Observer, NoteFormPresenter.Observer
{
    @Inject
    private HomeView homeView;

    @Inject
    private NoteModel noteModel;

    @Inject
    private NoteFormPresenter noteFormPresenter;

    @Override
    public void onEnter()
    {
        homeView.setObserver(this);
        homeView.setNotes(getNotesSortedByDateAscNotOlder1Hour());
    }

    @Override
    public View getView()
    {
        return homeView;
    }

    @Override
    public void onEdit(final long noteId)
    {
        noteFormPresenter.setObserver(this);
        final NoteDto note = noteModel.findNoteById(noteId);
        if (note != null){
            noteFormPresenter.setNote(note);
            homeView.showEditor(noteFormPresenter.getView());
        }
    }

    @Override
    public void onSave()
    {
        homeView.closeEditor();
        homeView.setNotes(getNotesSortedByDateAscNotOlder1Hour());
    }

    private List<NoteDto> getNotesSortedByDateAscNotOlder1Hour()
    {
        return noteModel.getNotesSortedByDateAscNotOlderThan(LocalDateTime.now().minusHours(1));
    }

    @Override
    public void onCancel()
    {
        homeView.closeEditor();
    }
}
