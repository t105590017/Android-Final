package com.example.gging.afinal;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Calculation extends Fragment {

    private MainActivity mainActivity;

    private TextView textView_Top, textView_In;
    private boolean Clear = false;
    private String CalculationProcess = "";
    private char Symbol = ' ';
    private int ans_temp;

    public Calculation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculation, container, false);

        mainActivity = (MainActivity) this.getActivity();

        textView_Top = view.findViewById(R.id.Txt_NumTop);
        textView_In = view.findViewById(R.id.Txt_NumIn);

        view.findViewById(R.id.btn_CE).setOnClickListener(Btn_CE_OnClick);
        view.findViewById(R.id.btn_C).setOnClickListener(Btn_C_OnClick);

        view.findViewById(R.id.btn_Div).setOnClickListener(Btn_Div_OnClick);
        view.findViewById(R.id.btn_Mul).setOnClickListener(Btn_Mul_OnClick);
        view.findViewById(R.id.btn_Add).setOnClickListener(Btn_Add_OnClick);
        view.findViewById(R.id.btn_Sub).setOnClickListener(Btn_Sub_OnClick);

        view.findViewById(R.id.btn_Neg).setOnClickListener(Btn_Neg_OnClick);
        view.findViewById(R.id.btn_Equal).setOnClickListener(Btn_Equal_OnClick);

        view.findViewById(R.id.btn_0).setOnClickListener(Btn_0_OnClick);
        view.findViewById(R.id.btn_1).setOnClickListener(Btn_1_OnClick);
        view.findViewById(R.id.btn_2).setOnClickListener(Btn_2_OnClick);
        view.findViewById(R.id.btn_3).setOnClickListener(Btn_3_OnClick);
        view.findViewById(R.id.btn_4).setOnClickListener(Btn_4_OnClick);
        view.findViewById(R.id.btn_5).setOnClickListener(Btn_5_OnClick);
        view.findViewById(R.id.btn_6).setOnClickListener(Btn_6_OnClick);
        view.findViewById(R.id.btn_7).setOnClickListener(Btn_7_OnClick);
        view.findViewById(R.id.btn_8).setOnClickListener(Btn_8_OnClick);
        view.findViewById(R.id.btn_9).setOnClickListener(Btn_9_OnClick);
        return view;
    }

    private View.OnClickListener Btn_CE_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textView_In.setText("0");
        }
    };

    private View.OnClickListener Btn_C_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            textView_In.setText("0");
            textView_Top.setText("");
            CalculationProcess = "";
            ans_temp = 0;
            Symbol = ' ';
        }
    };

    private void Operation_Btn () {
        int number = Integer.valueOf(textView_In.getText().toString()).intValue();
        switch (Symbol) {
            case ' ':
                CalculationProcess = String.valueOf(number);
                ans_temp = number;
                break;
            case '+':
                CalculationProcess = CalculationProcess + " + " + String.valueOf(number);
                ans_temp = ans_temp + number;
                break;
            case '-':
                CalculationProcess = CalculationProcess + " - " + String.valueOf(number);
                ans_temp = ans_temp - number;
                break;
            case '*':
                CalculationProcess = CalculationProcess + " ✕ " + String.valueOf(number);
                ans_temp = ans_temp * number;
                break;
            case '/':
                CalculationProcess = CalculationProcess + " ÷ " + String.valueOf(number);
                ans_temp = ans_temp / number;
                break;
            default:
                break;
        }
    }

    private View.OnClickListener Btn_Equal_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Operation_Btn();
            textView_In.setText(String.valueOf(ans_temp));
            mainActivity.record.RecordNew(String.valueOf(ans_temp));
            Clear = true;
            Symbol = ' ';
            textView_Top.setText("");
        }
    };

    private View.OnClickListener Btn_Neg_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Operation_Btn();
            ans_temp = -ans_temp;
            textView_In.setText(String.valueOf(ans_temp));
            Symbol = ' ';
            textView_Top.setText("");
        }
    };

    private View.OnClickListener Btn_Div_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!Clear) Operation_Btn();
            Symbol = '/';
            textView_Top.setText(CalculationProcess + " ÷ ");
            textView_In.setText(String.valueOf(ans_temp));
            Clear = true;
        }
    };

    private  View.OnClickListener Btn_Mul_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!Clear) Operation_Btn();
            Symbol = '*';
            textView_Top.setText(CalculationProcess + " ✕ ");
            textView_In.setText(String.valueOf(ans_temp));
            Clear = true;
        }
    };

    private  View.OnClickListener Btn_Add_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!Clear) Operation_Btn();
            Symbol = '+';
            textView_Top.setText(CalculationProcess + " + ");
            textView_In.setText(String.valueOf(ans_temp));
            Clear = true;
        }
    };

    private  View.OnClickListener Btn_Sub_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!Clear) Operation_Btn();
            Symbol = '-';
            textView_Top.setText(CalculationProcess + " - ");
            textView_In.setText(String.valueOf(ans_temp));
            Clear = true;
        }
    };

    private void Num_Btn(String num) {
        if(textView_In.getText().toString().equals("0") || Clear) {
            textView_In.setText(num);
            Clear = false;
        }
        else
            textView_In.setText(textView_In.getText().toString() + num);
    }

    private View.OnClickListener Btn_0_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Num_Btn("0");
        }
    };

    private View.OnClickListener Btn_1_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Num_Btn("1");
        }
    };

    private View.OnClickListener Btn_2_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Num_Btn("2");
        }
    };

    private View.OnClickListener Btn_3_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Num_Btn("3");
        }
    };

    private View.OnClickListener Btn_4_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Num_Btn("4");
        }
    };

    private View.OnClickListener Btn_5_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Num_Btn("5");
        }
    };

    private View.OnClickListener Btn_6_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Num_Btn("6");
        }
    };

    private View.OnClickListener Btn_7_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Num_Btn("7");
        }
    };

    private View.OnClickListener Btn_8_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Num_Btn("8");
        }
    };

    private View.OnClickListener Btn_9_OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Num_Btn("9");
        }
    };


}
