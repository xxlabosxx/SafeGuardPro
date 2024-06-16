package com.estudadospelanasa.safeguardpro.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.estudadospelanasa.safeguardpro.service.model.Funcionario
import com.estudadospelanasa.safeguardpro.service.repository.FuncionarioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class FuncionarioViewModel (application: Application): AndroidViewModel(application){
    private val repository = FuncionarioRepository(application)

    private val  mFuncionarioList = MutableLiveData<List<Funcionario>>()
    val funcionarioList: LiveData<List<Funcionario>> = mFuncionarioList

    private val mCreatedFuncionario = MutableLiveData<Funcionario>()
    val  createdfuncionario: LiveData<Funcionario> = mCreatedFuncionario

    private val mDeletedFuncionario = MutableLiveData<Boolean>()
    val deletedFuncionario: LiveData<Boolean> = mDeletedFuncionario

    private val mFuncionario = MutableLiveData<Funcionario>()
    val funcionario: LiveData<Funcionario> = mFuncionario

    private val mUpdatedFuncionario = MutableLiveData<Funcionario>()
    val updatedFuncionario: LiveData<Funcionario> = mUpdatedFuncionario

    private val mErro = MutableLiveData<String>()
    val erro: LiveData<String> = mErro

    fun load() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                mFuncionarioList.postValue(repository.getFuncionarios())
            } catch (e: Exception) {
                mErro.postValue(e.message)
            }
        }
    }

    fun insert(funcionario: Funcionario) {
        viewModelScope.launch(Dispatchers.IO){
            try {
                val createdFuncionario = repository.insertFuncionario(funcionario)
            }catch (e: Exception){
                mErro.postValue(e.message)
            }
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try{
                mDeletedFuncionario.postValue(repository.deleteFuncionario(id))
            } catch (e: Exception) {
                mErro.postValue((e.message))
            }
        }
    }

    fun getFuncionario(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try{
                mFuncionario.postValue(repository.getFuncionario(id))
            } catch (e: Exception) {
                mErro.postValue((e.message))
            }
        }
    }

    fun getFuncionarioByCpf(cpf: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                mFuncionario.postValue(repository.getFuncionarioByCpf(cpf))
            } catch (e: Exception) {
                mErro.postValue(e.message)
            }
        }
    }

    fun update(funcionario: Funcionario) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val updatedFuncionario = repository.updateFuncionario(funcionario)
                mUpdatedFuncionario.postValue(updatedFuncionario)
            } catch (e: Exception){
                mErro.postValue(e.message)
            }
        }
    }
}