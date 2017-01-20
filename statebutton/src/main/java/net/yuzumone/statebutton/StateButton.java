/*
 * Copyright (C) 2017 yuzumone
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package net.yuzumone.statebutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.TextView;

public class StateButton extends TextView {

    private Context context;
    private boolean isChecked;
    private String trueText = "";
    private String falseText = "";
    private OnStateButtonListener listener;

    public StateButton(Context context) {
        this(context, null);
    }

    public StateButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.buttonStyle);
    }

    public StateButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        this.context = context;
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.StateButton, defStyle, 0);
        Boolean state = array.getBoolean(R.styleable.StateButton_state, false);

        trueText = array.getString(R.styleable.StateButton_trueText);
        int trueStringRes = array.getResourceId(R.styleable.StateButton_trueTextRes, 0);
        if (trueStringRes != 0) {
            trueText = context.getString(trueStringRes);
        }
        falseText = array.getString(R.styleable.StateButton_falseText);
        int falseStringRes = array.getResourceId(R.styleable.StateButton_falseTextRes, 0);
        if (falseStringRes != 0) {
            falseText = context.getString(falseStringRes);
        }

        setState(state);
        array.recycle();
    }

    public void setState(Boolean state) {
        if (state) {
            isChecked = true;
            this.setText(trueText);
        } else {
            isChecked = false;
            this.setText(falseText);
        }
    }

    public void setOnStateButtonListener(OnStateButtonListener listener) {
        this.listener = listener;
    }

    public void setTrueText(String trueText) {
        this.trueText = trueText;
        if (isChecked) this.setText(trueText);
    }

    public void setTrueText(@StringRes int resId) {
        this.trueText = context.getString(resId);
        if (isChecked) this.setText(trueText);
    }

    public void setFalseText(String falseText) {
        this.falseText = falseText;
        if (!isChecked) this.setText(falseText);
    }

    public void setFalseText(@StringRes int resId) {
        this.falseText = context.getString(resId);
        if (!isChecked) this.setText(falseText);
    }

    @Override
    public boolean performClick() {
        isChecked = !isChecked;
        this.setText(isChecked ? trueText : falseText);

        if (listener != null) {
            if (isChecked) {
                listener.trued(this);
            } else {
                listener.falsed(this);
            }
        }
        return super.performClick();
    }
}
