package task.test.robert.testapp.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import task.test.robert.testapp.R;
import task.test.robert.testapp.core.model.Board;
import task.test.robert.testapp.core.recyclerView.RecyclerInterface;
import task.test.robert.testapp.core.recyclerView.RecyclerViewAdapter;
import task.test.robert.testapp.core.retrofit.RequestManager;
import task.test.robert.testapp.core.retrofit.ResponseCallback;
import task.test.robert.testapp.util.Constants;

/**
 * Activity for loading and showing boards
 * <p>
 * This activity is used to display all boards names on user interface design.
 */
public class MainActivity extends AppCompatActivity implements RecyclerInterface {
    private List<Board> boardList;
    private RequestManager requestManager;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewsConfigs();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllProjects();
    }


    /**
     * This method contains all views configurations codes(findViewById)
     */
    private void viewsConfigs() {
        boardList = new ArrayList<>();
        requestManager = new RequestManager();
        RecyclerView projectsRecycler = findViewById(R.id.projects_recycler_view);
        adapter = new RecyclerViewAdapter(boardList, this, R.layout.projects_item);
        projectsRecycler.setLayoutManager(new LinearLayoutManager(this));
        projectsRecycler.setAdapter(adapter);
        findViewById(R.id.add_board_action_button).setOnClickListener(l -> showAddNewBoardAlert());
    }


    /**
     * This method gets all data from server by http request.
     */
    public void getAllProjects() {
        requestManager.getAllBoards(new ResponseCallback() {
            @Override
            public void success(Object object) {
                boardList.clear();
                boardList.addAll((List) object);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void fail(String error, int errorCode) {
                System.out.println("error = " + error + "\nerrorCode = " + errorCode);
            }
        });
    }

    /**
     * The method shows dialog to write the new board name and send the addNewBoard request.
     */
    private void showAddNewBoardAlert() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_new_board_layout);
        EditText nameField = dialog.findViewById(R.id.board_name_field);
        Button dialogButton = dialog.findViewById(R.id.add_board_button);
        dialogButton.setOnClickListener(view -> {
            addNewBoardActionPerformed(nameField.getText().toString());
            dialog.dismiss();
        });
        dialog.show();
    }

    /**
     * The method sends the addNewBoard request.
     * If response has body the added object of Board class would be added in the array and the list will refreshed.
     * Otherwise will be shown an error message
     *
     * @param name is the name that user wrote for new board, if name is empty, program show warning that name can not be empty, and method will not continue executing.
     */
    private void addNewBoardActionPerformed(String name) {
        if (name.isEmpty()) {
            Toast.makeText(this, "Board name may not be empty!!", Toast.LENGTH_SHORT).show();
            return;
        }
        requestManager.addNewBoard(name, new ResponseCallback() {
            @Override
            public void success(Object object) {
                boardList.add((Board) object);
                adapter.notifyDataSetChanged();
               //NOTE:: There can be also called get All boards request to get all boards sorted by server side at once.
               //getAllProjects();
            }

            @Override
            public void fail(String error, int errorCode) {
                System.out.println(error);
            }
        });

    }

    @Override
    public void onRecyclerViewItemClick(int position) {
        Intent intent = new Intent(this, IndividualBoardActivity.class);
        intent.putExtra(Constants.SELECTED_BOARD, boardList.get(position));
        startActivity(intent);
    }
}

