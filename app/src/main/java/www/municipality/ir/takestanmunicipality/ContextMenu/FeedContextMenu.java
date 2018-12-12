package www.municipality.ir.takestanmunicipality.ContextMenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import www.municipality.ir.takestanmunicipality.R;
import www.municipality.ir.takestanmunicipality.Tools;


public class FeedContextMenu extends LinearLayout {
    private final int CONTEXT_MENU_WIDTH = Tools.getInstance(getContext()).dpToPx(240);

    private int feedItem = -1;

    private OnFeedContextMenuItemClickListener onItemClickListener;

    public FeedContextMenu(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_context_menu, this, true);
//        setBackgroundResource(R.drawable.ic_launcher_background);
        setOrientation(VERTICAL);
        setLayoutParams(new LayoutParams(CONTEXT_MENU_WIDTH, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void bindToItem(int feedItem) {
        this.feedItem = feedItem;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
//        ButterKnife.bind(this);
    }

    public void dismiss() {
        ((ViewGroup) getParent()).removeView(FeedContextMenu.this);
    }
//
//    @OnClick(R.id.btnReport)
//    public void onReportClick() {
//        if (onItemClickListener != null) {
//            onItemClickListener.onReportClick(feedItem);
//        }
//    }
//
//    @OnClick(R.id.btnSharePhoto)
//    public void onSharePhotoClick() {
//        if (onItemClickListener != null) {
//            onItemClickListener.onSharePhotoClick(feedItem);
//        }
//    }
//
//    @OnClick(R.id.btnCopyShareUrl)
//    public void onCopyShareUrlClick() {
//        if (onItemClickListener != null) {
//            onItemClickListener.onCopyShareUrlClick(feedItem);
//        }
//    }
//
//    @OnClick(R.id.btnCancel)
//    public void onCancelClick() {
//        if (onItemClickListener != null) {
//            onItemClickListener.onCancelClick(feedItem);
//        }
//    }

    public void setOnFeedMenuItemClickListener(OnFeedContextMenuItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnFeedContextMenuItemClickListener {
        public void onReportClick(int feedItem);

        public void onSharePhotoClick(int feedItem);

        public void onCopyShareUrlClick(int feedItem);

        public void onCancelClick(int feedItem);
    }
}