package seedu.address.logic.parser;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.LoginCommand;
import seedu.address.logic.commands.LogoutCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;

//@@author: IcedCoffeeBoy


/**
 * Parses user input.
 */
public class ProManageParser {
    /**
     * Used for initial separation of command word and args.
     */

    private CommandsParser commandsParser;

    public ProManageParser() {
        this.commandsParser = new DefaultParser();
    }

    /**
     * @param userInput
     * @return Command
     * @throws ParseException
     */

    public Command parseCommand(String userInput) throws CommandException, ParseException {
        Command command = commandsParser.parseCommand(userInput);
        if (command instanceof LoginCommand) {
            this.commandsParser = ((LoginCommand) command).getParser();
        } else if (command instanceof LogoutCommand) {
            this.commandsParser = ((LogoutCommand) command).getParser();
        }
        return command;
    }
}
