package com.socialpost.base;

import androidx.fragment.app.Fragment;

public class BaseFragment<T extends BaseViewModel> extends Fragment implements ViewModelSource<T> {


    @Override
    public T getViewModel() {
        if (getActivity() == null) {
            throw new IllegalStateException("View Model should be used ONLY when in an activity");
        }
        if (!(getActivity() instanceof ViewModelSource)) {
            throw new IllegalStateException("This fragment's activity must implement ViewModelSource");
        }
        return ((ViewModelSource<T>) getActivity()).getViewModel();
    }


}