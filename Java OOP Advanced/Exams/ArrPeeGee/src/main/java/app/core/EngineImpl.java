package app.core;

import app.contracts.Battlefield;
import app.contracts.Engine;
import app.contracts.Reader;
import app.contracts.Writer;

import java.io.IOException;
import java.util.Arrays;

import static app.models.Constants.*;

public class EngineImpl implements Engine {

    private Reader reader;
    private Battlefield battleField;
    private Writer writer;

    public EngineImpl(Reader reader, Battlefield battleField, Writer writer) {
        this.reader = reader;
        this.battleField = battleField;
        this.writer = writer;
    }

    @Override
    public void run() throws IOException {
        String line;
        while (!TERMINATING_COMMAND.equals(line = this.reader.readLine())) {
            String[] tokens = line.split(WORD_SPLITTER);

            switch (tokens[0].toLowerCase()) {
                case CREATE_PARTICIPANT:
                    this.battleField.createParticipant(tokens[1], tokens[2]);
                    break;
                case CREATE_ACTION:
                    this.battleField.createAction(tokens[1],
                            Arrays.copyOf(Arrays.stream(tokens).skip(2).toArray(),
                                    Arrays.stream(tokens).skip(2).toArray().length,
                                    String[].class));
                    break;
                case CREATE_SPECIAL:
                    this.battleField.createSpecial(tokens[1], tokens[2]);
                    break;
                case STAT_PARTICIPANTS:
                    this.battleField.reportParticipants();
                    break;
                case STAT_ACTIONS:
                    this.battleField.reportActions();
                    break;
                default:
                    this.writer.writeLine(INVALID_COMMAND_MESSAGE);
                    break;
            }
        }
    }
}
