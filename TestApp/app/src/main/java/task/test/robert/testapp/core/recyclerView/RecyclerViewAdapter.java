package task.test.robert.testapp.core.recyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List list;
    private Context context;
    private int layout;
    private RecyclerInterface recyclerInterface;

    public RecyclerViewAdapter(List list, RecyclerInterface recyclerInterface, int layoutId) {
        this.list = list;
        this.context = recyclerInterface.getApplicationContext();
        this.layout = layoutId;
        this.recyclerInterface = recyclerInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(layout, null);
        return new ItemRowHolder(v, context, recyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder itemRowHolder, int position) {
        ((ItemRowHolder) itemRowHolder).reloadDataWithObjects(list.get(position), position);
    }


    @Override
    public int getItemCount() {
        return (null != list ? list.size() : 0);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}