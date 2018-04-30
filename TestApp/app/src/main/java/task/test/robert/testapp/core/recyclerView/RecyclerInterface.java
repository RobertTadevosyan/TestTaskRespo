package task.test.robert.testapp.core.recyclerView;


import android.content.Context;

public interface RecyclerInterface {
    /**
     * Method should be called when recyclerview item is was clicked
     *
     * @param position is the clicked item position in array
     */
    void onRecyclerViewItemClick(int position);


    /**
     * Method should return application context
     */
    Context getApplicationContext();
}
