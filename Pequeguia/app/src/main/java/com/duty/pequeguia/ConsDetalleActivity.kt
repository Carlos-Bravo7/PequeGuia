package com.duty.pequeguia

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.max
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.duty.pequeguia.data.Consejo
import com.duty.pequeguia.presentation.consejo_detallado
import com.duty.pequeguia.ui.theme.PequeguiaTheme

class ConsDetalleActivity : ComponentActivity() {

    private val consejo:Consejo by lazy {
        intent?.getSerializableExtra(CON_ID) as Consejo
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PequeguiaTheme {
                consejo_detallado(consejo = consejo)
            }
        }
    }
    companion object{
        private const val CON_ID = "consejo_id"
        fun newIntent(context: Context, consejo:Consejo) = Intent(context,ConsDetalleActivity::class.java).
                apply { putExtra(CON_ID, consejo) }
    }
}


