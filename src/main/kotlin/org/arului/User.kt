package org.arului

import kotlin.browser.window

val API_URL = "https://gist.githubusercontent.com/arulkumar-lab/3ede81ba991e20a69484a59163f20342/raw/cb807e01b42ee3aac9d14e04ec5cf3c11127fa1e/sample1.json"

fun main(args: Array<String>) {
    val userImgPresenter = UserImagePresenter()
    val userImagePage = UserImagePage(userImgPresenter)
    userImgPresenter.attach(userImagePage)
    userImgPresenter.loadUserImages();
}