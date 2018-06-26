package com.example.myroomtest;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by Marco on 20/06/2018.
 */

public class UsersViewModel extends AndroidViewModel {
    private UsersRepository mRepository;
    private LiveData<List<Users>> mAllUsers;

    public UsersViewModel(Application application) {
        super(application);
        mRepository = new UsersRepository(application);
        mAllUsers = mRepository.getAllUsers();
    }

    LiveData<List<Users>> getAllUsers() { return mAllUsers; }

    public void insert(Users user) { mRepository.insert(user); }
    public void delete(Users user) { mRepository.delete(user); }
}
