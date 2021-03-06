package com.ghostapps.placapp.ui.gameRecords

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghostapps.placapp.R
import com.ghostapps.placapp.databinding.ActivityGameRecordsBinding
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.ui.gameRecords.adapter.RecordsListAdapter
import com.ghostapps.placapp.viewModel.gameRecords.GameRecordsViewModel
import kotlinx.android.synthetic.main.activity_game_records.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import javax.annotation.Nullable

@OptIn(ObsoleteCoroutinesApi::class)
class GameRecordsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityGameRecordsBinding
    private val viewModel: GameRecordsViewModel by viewModel { parametersOf(this) }
    private val scope = CoroutineScope(newSingleThreadContext("scope"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game_records)
        binding.viewModel = viewModel

        setSupportActionBar(gameRecordsToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.recordsList.observe(this, Observer { recordsList ->
            val adapter = RecordsListAdapter(recordsList, onDeletePressed = { gameRecord ->
                var dialog: AlertDialog? = null
                dialog = AlertDialog.Builder(this)
                    .setTitle("Remover Registro")
                    .setMessage("Tem certeza que quer remover esse registro? Essa opera????o n??o poder?? ser desfeita")
                    .setPositiveButton("Sim, quero remover") { _, _ ->
                        deleteRegister(gameRecord)
                        dialog?.cancel()
                    }
                    .setNegativeButton("Deixa quieto") { _, _ ->
                        dialog?.cancel()
                    }.create()
                dialog.show()
            })
            gameRecordsList.layoutManager = LinearLayoutManager(this)
            gameRecordsList.adapter = adapter
        })

        loadRecords()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


    private fun deleteRegister(gameRecord: RecordModel) {
        scope.launch { viewModel.deleteRegister(gameRecord) }
    }

    private fun loadRecords() {
        scope.launch { viewModel.loadRecords() }
    }

}