package com.example.dynam.menutemple;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class CategoriaActivity extends BaseActivity {
    public Integer id;
    public Integer APPETIZER=R.layout.content_appetizer,SUSHIBAR=R.layout.content_categoria,ESPECIALIDADES=R.layout.content_especialidades,BAR=R.layout.content_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle parameters = getIntent().getExtras();
        super.onCreate(savedInstanceState);
        setContentView(parameters.getInt("categoria"));
        id = parameters.getInt("categoria");
        System.out.println(id);
        //SUSHIBAR=parameters.getInt(R.id.c);
        if(id==R.layout.content_categoria) {
            System.out.println(id);
            ImageView btn7 = (ImageView) findViewById(R.id.imageButton7);
            ImageView btn8 = (ImageView) findViewById(R.id.imageButton8);
            ImageView btn9 = (ImageView) findViewById(R.id.imageButton9);
            ImageView btn10 = (ImageView) findViewById(R.id.imageButton10);
            ImageView btn11 = (ImageView) findViewById(R.id.imageButton11);

            btn7.setOnClickListener(onClickListener);
            btn8.setOnClickListener(onClickListener);
            btn9.setOnClickListener(onClickListener);
            btn10.setOnClickListener(onClickListener);
            btn11.setOnClickListener(onClickListener);
        }
        if(id==R.layout.content_appetizer){
            ImageView btn12 = (ImageView) findViewById(R.id.imageButton12);
            ImageView btn13 = (ImageView) findViewById(R.id.imageButton13);

            btn12.setOnClickListener(onClickListener);
            btn13.setOnClickListener(onClickListener);
        }
        if(id==R.layout.content_especialidades){
            ImageView btn14 = (ImageView) findViewById(R.id.imageButton14);
            ImageView btn15 = (ImageView) findViewById(R.id.imageButton15);
            ImageView btn16 = (ImageView) findViewById(R.id.imageButton16);
            ImageView btn17 = (ImageView) findViewById(R.id.imageButton17);
            ImageView btn18 = (ImageView) findViewById(R.id.imageButton18);

            btn14.setOnClickListener(onClickListener);
            btn15.setOnClickListener(onClickListener);
            btn16.setOnClickListener(onClickListener);
            btn17.setOnClickListener(onClickListener);
            btn18.setOnClickListener(onClickListener);

        }
        if(id==R.layout.content_bar){
            ImageView btn19 = (ImageView) findViewById(R.id.imageButton19);
            ImageView btn20 = (ImageView) findViewById(R.id.imageButton20);
            ImageView btn21 = (ImageView) findViewById(R.id.imageButton21);
            ImageView btn22 = (ImageView) findViewById(R.id.imageButton22);
            ImageView btn23 = (ImageView) findViewById(R.id.imageButton23);
            ImageView btn24 = (ImageView) findViewById(R.id.imageButton24);

            btn19.setOnClickListener(onClickListener);
            btn20.setOnClickListener(onClickListener);
            btn21.setOnClickListener(onClickListener);
            btn22.setOnClickListener(onClickListener);
            btn23.setOnClickListener(onClickListener);
            btn24.setOnClickListener(onClickListener);
        }

    }



    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            Intent intent;
            if(id==R.layout.content_categoria) {
                switch (v.getId()) {
                    case R.id.imageButton7:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "fusion");
                        startActivity(intent);

                        break;

                    case R.id.imageButton8:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "hosomaki");
                        startActivity(intent);


                        break;
                    case R.id.imageButton9:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "nigiri");
                        startActivity(intent);


                        break;
                    case R.id.imageButton10:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "onigiri");
                        startActivity(intent);


                        break;
                    case R.id.imageButton11:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "sashimi");
                        startActivity(intent);


                        break;
                }
            }
            if(id==R.layout.content_appetizer){
                switch (v.getId()) {
                    case R.id.imageButton12:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "appetizer_frio");
                        startActivity(intent);

                        break;

                    case R.id.imageButton13:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "ecaliente");
                        startActivity(intent);


                        break;
                }
            }

            if(id==R.layout.content_especialidades) {
                switch (v.getId()) {
                    case R.id.imageButton14:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "arroces");
                        startActivity(intent);

                        break;

                    case R.id.imageButton15:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "carnes");
                        startActivity(intent);


                        break;
                    case R.id.imageButton16:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "pescados");
                        startActivity(intent);


                        break;
                    case R.id.imageButton17:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "sopas");
                        startActivity(intent);


                        break;
                    case R.id.imageButton18:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "vegetales");
                        startActivity(intent);


                        break;
                }
            }
            if(id==R.layout.content_bar) {
                switch (v.getId()) {
                    case R.id.imageButton19:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "jugos");
                        startActivity(intent);

                        break;

                    case R.id.imageButton20:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "aperitivos");
                        startActivity(intent);


                        break;
                    case R.id.imageButton21:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "cervezas");
                        startActivity(intent);


                        break;
                    case R.id.imageButton22:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "vinos");
                        startActivity(intent);


                        break;
                    case R.id.imageButton23:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "cocktel");
                        startActivity(intent);


                        break;
                    case R.id.imageButton24:
                        intent = new Intent(CategoriaActivity.this, MenuActivity.class).putExtra("categoria", "destilados");
                        startActivity(intent);


                        break;
                }
            }
        }
    };
}
