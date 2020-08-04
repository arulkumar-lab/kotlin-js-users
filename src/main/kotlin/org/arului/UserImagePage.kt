package org.arului

import org.arului.modal.UserImage
import kotlin.browser.document
import org.w3c.dom.HTMLDivElement

class UserImagePage(private val presenter: UserImageContract.Presenter) : UserImageContract.View {

    private val loader = document.getElementById("loader") as HTMLDivElement
    private val content = document.getElementById("content") as HTMLDivElement
    private val userImageThumbnailBuilder = UserImageThumbnailBuilder()

    override fun showUserImages(userImages: List<UserImage>) {
        userImages.forEach { userImage ->
            val userImgThump = userImageThumbnailBuilder.generateContainer(userImage)
            content.appendChild(userImgThump)
        }
        content.style.visibility = "visible"
    }

    override fun showLoader() {
        loader.style.visibility = "visible"
    }

    override fun hideLoader() {
        loader.style.visibility = "hidden"
    }

}