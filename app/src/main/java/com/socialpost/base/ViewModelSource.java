package com.socialpost.base;

import androidx.lifecycle.ViewModel;

public interface ViewModelSource<T extends ViewModel> {
    T getViewModel();
}
