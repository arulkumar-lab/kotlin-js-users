package org.arului

import org.arului.modal.UserImage

interface UserImageContract {
    interface View {
        fun showUserImages(userImages: List<UserImage>) // 1
        fun showLoader() // 2
        fun hideLoader() // 3
    }

    interface Presenter {
        fun attach(view: View) // 4
        fun loadUserImages() // 5
    }
}