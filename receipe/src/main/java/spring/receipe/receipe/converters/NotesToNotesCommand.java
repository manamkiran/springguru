package spring.receipe.receipe.converters;


import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;
import spring.receipe.receipe.commands.NotesCommand;
import spring.receipe.receipe.model.Notes;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand>{

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        if (source == null) {
            return null;
        }

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNotes(source.getRecipeNotes());
        return notesCommand;
    }
}
