package com.example.async_sortowanie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SortingView extends View {

    private int[] array = new int[0];
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public SortingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.BLUE);
    }

    public void setArray(int[] array) {
        this.array = array;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (array == null || array.length == 0) {
            return;
        }

        int width = getWidth();
        int height = getHeight();
        float barWidth = (float) width / array.length;

        for (int i = 0; i < array.length; i++) {
            float barHeight = ((float) array[i] / 500) * height;
            float left = i * barWidth;
            float top = height - barHeight;
            float right = left + barWidth;
            float bottom = height;

            canvas.drawRect(left, top, right, bottom, paint);
        }
    }
}
