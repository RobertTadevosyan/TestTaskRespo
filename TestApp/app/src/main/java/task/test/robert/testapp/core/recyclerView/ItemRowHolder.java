package task.test.robert.testapp.core.recyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import task.test.robert.testapp.R;
import task.test.robert.testapp.core.model.Board;


public class ItemRowHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context context;
    private RecyclerInterface recyclerInterface;
    private int position;
    private TextView nameTextView;


    public ItemRowHolder(View row, Context context, RecyclerInterface recyclerInterface) {
        super(row);
        row.setTag(ItemRowHolder.this);
        this.context = context;
        this.recyclerInterface = recyclerInterface;
        nameTextView = row.findViewById(R.id.name_tv);
        row.setOnClickListener(this);
    }


    public void reloadDataWithObjects(Object object, int position) {
        this.position = position;
        Board board = (Board) object;
        nameTextView.setText(board.getName());

    }

    @Override
    public void onClick(View v) {
        recyclerInterface.onRecyclerViewItemClick(position);
    }

}