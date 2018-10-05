package by.boiko.test.testapp.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.boiko.test.testapp.R;
import by.boiko.test.testapp.data.ResponseModel.Currency;
import by.boiko.test.testapp.data.ResponseModel.DailyExRates;
import by.boiko.test.testapp.ui.base.BaseViewHolder;

public class TestAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Currency> currencies = new ArrayList<>();

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TestAdapter.TestViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.items_rv, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    private Context context;

    public void setItems(List<Currency> currencies) {
        this.currencies.addAll(currencies);
        notifyDataSetChanged();
    }

    public class TestViewHolder extends BaseViewHolder {

        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.arrow_down)
        ImageButton arrowDown;
        @BindView(R.id.arrow_up)
        ImageButton arrowUp;

        public TestViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }

        @Override
        public void onBind(int position) {
            if (position == 0) {
                arrowUp.setVisibility(View.GONE);
                arrowDown.setVisibility(View.VISIBLE);
            } else if (position == currencies.size() - 1) {
                arrowUp.setVisibility(View.VISIBLE);
                arrowDown.setVisibility(View.GONE);
            } else {
                arrowUp.setVisibility(View.VISIBLE);
                arrowDown.setVisibility(View.VISIBLE);
            }

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(currencies.get(position).getCharCode())
                    .append(" ").append(currencies.get(position).getRate())
                    .append(" ").append("BYN")
                    .append(" ").append(currencies.get(position).getName())
                    .append(" ").append("за ").append(currencies.get(position).getScale()).append(" ед.");
            textView.setText(stringBuilder);
            arrowUp.setOnClickListener(v -> {
                Currency deleted = currencies.get(position);
                currencies.remove(position);
                currencies.add(position - 1, deleted);
                notifyDataSetChanged();
            });
            arrowDown.setOnClickListener(v -> {
                Currency deleted = currencies.get(position);
                currencies.remove(position);
                currencies.add(position + 1, deleted);
                notifyDataSetChanged();
            });

        }

    }
}