package seedu.jarvis.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.jarvis.logic.commands.CommandTestUtil.VALID_USERNAME_PROF;
import static seedu.jarvis.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.jarvis.logic.commands.ExitCommand.MESSAGE_EXIT_ACKNOWLEDGEMENT;

import org.junit.jupiter.api.Test;

import seedu.jarvis.logic.commands.edit.EditLoginCommand;
import seedu.jarvis.model.Model;
import seedu.jarvis.model.ModelManager;
import seedu.jarvis.model.UserLogin;
import seedu.jarvis.testutil.EditLoginDescriptorBuilder;
import seedu.jarvis.testutil.LoginBuilder;

public class ExitCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_exit_success() {
        CommandResult expectedCommandResult = new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, false, true);
        assertCommandSuccess(new ExitCommand(), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_exit_commandTargetFeatureNotAssigned() {
        ExitCommand exitCommand = new ExitCommand();

        CommandResult commandResult = exitCommand.execute(model);
        CommandTargetFeature commandTargetFeature = commandResult.getCommandTargetFeature();

        assertEquals(CommandTargetFeature.NotAssigned, commandTargetFeature);
    }

}
