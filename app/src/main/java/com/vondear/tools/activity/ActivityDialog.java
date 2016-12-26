package com.vondear.tools.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;

import com.vondear.tools.R;
import com.vondear.vontools.view.DialogEditTextSureCancle;
import com.vondear.vontools.view.DialogLoadingProgressAcfunVideo;
import com.vondear.vontools.view.DialogSure;
import com.vondear.vontools.view.DialogSureCancle;
import com.vondear.vontools.view.dialogShapeLoadingView.ShapeLoadingDialog;
import com.vondear.vontools.view.dialogWheel.DialogWheelYearMonthDay;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityDialog extends AppCompatActivity {

    @BindView(R.id.button_DialogSure)
    Button buttonDialogSure;
    @BindView(R.id.button_DialogSureCancle)
    Button buttonDialogSureCancle;
    @BindView(R.id.button_DialogEditTextSureCancle)
    Button buttonDialogEditTextSureCancle;
    @BindView(R.id.button_DialogWheelYearMonthDay)
    Button mButtonDialogWheelYearMonthDay;
    @BindView(R.id.button_DialogShapeLoading)
    Button mButtonDialogShapeLoading;
    @BindView(R.id.button_DialogLoadingProgressAcfunVideo)
    Button mButtonDialogLoadingProgressAcfunVideo;


    private Context context;

    private DialogWheelYearMonthDay mDialogWheelYearMonthDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
        context = this;
    }

    private void initWheelYearMonthDayDialog() {
        // ------------------------------------------------------------------选择日期开始
        mDialogWheelYearMonthDay = new DialogWheelYearMonthDay(this);
        mDialogWheelYearMonthDay.getTv_sure().setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        if (mDialogWheelYearMonthDay.getCheckBox_day().isChecked()) {
                            mButtonDialogWheelYearMonthDay.setText((mDialogWheelYearMonthDay.getCurYear() - 5) + mDialogWheelYearMonthDay.getYear().getCurrentItem() + "年"
                                    + mDialogWheelYearMonthDay.getMonths()[mDialogWheelYearMonthDay.getMonth().getCurrentItem()] + "月"
                                    + (mDialogWheelYearMonthDay.getDay().getCurrentItem() + 1) + "日");
                        } else {
                            mButtonDialogWheelYearMonthDay.setText((mDialogWheelYearMonthDay.getCurYear() - 5) + mDialogWheelYearMonthDay.getYear().getCurrentItem() + "年"
                                    + mDialogWheelYearMonthDay.getMonths()[mDialogWheelYearMonthDay.getMonth().getCurrentItem()] + "月");
                        }
                        mDialogWheelYearMonthDay.cancel();
                    }
                });
        mDialogWheelYearMonthDay.getTv_cancle().setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        mDialogWheelYearMonthDay.cancel();
                    }
                });
        // ------------------------------------------------------------------选择日期结束
    }

    @OnClick({R.id.button_DialogSure, R.id.button_DialogSureCancle, R.id.button_DialogEditTextSureCancle, R.id.button_DialogWheelYearMonthDay, R.id.button_DialogShapeLoading, R.id.button_DialogLoadingProgressAcfunVideo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_DialogSure:
                final DialogSure dialogSure = new DialogSure(context);//提示弹窗
                dialogSure.getTv_content().setMovementMethod(ScrollingMovementMethod.getInstance());
                dialogSure.getTv_sure().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogSure.cancel();
                    }
                });
                dialogSure.show();
                break;
            case R.id.button_DialogSureCancle:
                final DialogSureCancle dialogSureCancle = new DialogSureCancle(context);//提示弹窗
                dialogSureCancle.getTv_sure().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogSureCancle.cancel();
                    }
                });
                dialogSureCancle.getTv_cancle().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogSureCancle.cancel();
                    }
                });
                dialogSureCancle.show();
                break;
            case R.id.button_DialogEditTextSureCancle:
                final DialogEditTextSureCancle dialogEditTextSureCancle = new DialogEditTextSureCancle(context);//提示弹窗
                dialogEditTextSureCancle.getTv_sure().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogEditTextSureCancle.cancel();
                    }
                });
                dialogEditTextSureCancle.getTv_cancle().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogEditTextSureCancle.cancel();
                    }
                });
                dialogEditTextSureCancle.show();
                break;
            case R.id.button_DialogWheelYearMonthDay:
                initWheelYearMonthDayDialog();
                mDialogWheelYearMonthDay.show();
                break;
            case R.id.button_DialogShapeLoading:
                ShapeLoadingDialog shapeLoadingDialog = new ShapeLoadingDialog(this);
                shapeLoadingDialog.show();
                break;
            case R.id.button_DialogLoadingProgressAcfunVideo:
                new DialogLoadingProgressAcfunVideo(this).show();
                break;
        }
    }
}
