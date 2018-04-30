package task.test.robert.testapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import task.test.robert.testapp.R;
import task.test.robert.testapp.core.model.Board;
import task.test.robert.testapp.util.Constants;

/**
 * Activity for showing selected board information.
 *
 * This activity is used to display more information about selected board on user interface design.
 *
 */
public class IndividualBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_board);
        TextView infoTextView = findViewById(R.id.info_text_view);
        Intent intent = getIntent();
        if (intent.hasExtra(Constants.SELECTED_BOARD)) {
            Board board = (Board) intent.getSerializableExtra(Constants.SELECTED_BOARD);
            infoTextView.setText(board.toString());
        }
    }
}
