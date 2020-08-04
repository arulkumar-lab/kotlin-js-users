package org.arului.modal

class UserImage {
    var author: String = "";
    var authorID: String = "";
    var description: String = "";
    var link: String = "";
    var published: String = "";
    var tags: String = "";
    var title: String = "";

    data class UserImage(val title: String,
                         val author: String,
                         val description: String,
                         val link: String,
                         val tags: String,
                         val published: String)
}