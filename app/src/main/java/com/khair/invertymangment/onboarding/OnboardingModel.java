package com.khair.invertymangment.onboarding;

import androidx.fragment.app.Fragment;

public class OnboardingModel {
    private String tittle;
    private Class <?extends Fragment>fragmentclass;

    public OnboardingModel(String tittle, Class<? extends Fragment> fragmentclass) {
        this.tittle = tittle;
        this.fragmentclass = fragmentclass;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Class<? extends Fragment> getFragmentclass() {
        return fragmentclass;
    }

    public void setFragmentclass(Class<? extends Fragment> fragmentclass) {
        this.fragmentclass = fragmentclass;
    }
}
