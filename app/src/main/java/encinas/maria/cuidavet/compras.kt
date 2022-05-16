package encinas.maria.cuidavet

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class compras : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compras)

        val ivShampoo : ImageView = findViewById(R.id.iv_shampoo)
        val ivCepillo : ImageView = findViewById(R.id.iv_cepillo)
        val ivPelota : ImageView = findViewById(R.id.iv_pelota)
        val ivRopa : ImageView = findViewById(R.id.iv_ropa)
        val ivCorrea : ImageView = findViewById(R.id.iv_correa)
        val ivCollar : ImageView = findViewById(R.id.iv_collar)

        ivShampoo.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com.mx/s?k=shampoo+para+mascotas&i=pets&sprefix=shampoo+para+ma%2Cpets%2C554&ref=nb_sb_ss_ts-doa-p_1_15"))
            startActivity(intent)
        }
        ivCepillo.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com.mx/s?k=cepillos+para+mascotas&i=pets&__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=RSNPKY74FC3U&sprefix=cepillo+para+mascotas%2Cpets%2C261&ref=nb_sb_noss_1"))
            startActivity(intent)
        }
        ivPelota.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com.mx/s?k=juguetes+para+mascotas&i=pets&__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1IKMXQNQVKGWY&sprefix=juguetes+para+mascotas%2Cpets%2C221&ref=nb_sb_noss_1"))
            startActivity(intent)
        }
        ivRopa.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com.mx/s?k=ropa+para+mascotas&i=pets&__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2NYLKS0VULS02&sprefix=ropa+para+mascotas%2Cpets%2C255&ref=nb_sb_noss_1"))
            startActivity(intent)
        }
        ivCorrea.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com.mx/s?k=correa+para+mascotas&i=pets&__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1U108P08KJP2C&sprefix=correa+para+mascotas%2Cpets%2C254&ref=nb_sb_noss_1"))
            startActivity(intent)
        }
        ivCollar.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com.mx/s?k=collar+para+mascotas&i=pets&__mk_es_MX=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3KGMH7B8T2ZS2&sprefix=collar+para+mascotas%2Cpets%2C217&ref=nb_sb_noss_1"))
            startActivity(intent)
        }
    }
}