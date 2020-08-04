package org.arului

import org.arului.modal.UserImage
import kotlin.browser.document
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.Element

class UserImageThumbnailBuilder {

    fun generateContainer(userImage: UserImage): HTMLElement {

        var containerDiv = document.createElement("div") as HTMLDivElement
        var title = document.createElement("div") as HTMLDivElement
        var author = document.createElement("div") as HTMLDivElement
        var description = document.createElement("div") as HTMLDivElement

        loadContainerValues(userImage = userImage, title = title, author = author, description = description)

        containerDiv.appendChild(
                title,
                author,
                description
        )
        return containerDiv;
    }

    private fun loadContainerValues(userImage: UserImage,
                                    title: HTMLDivElement,
                                    author: HTMLDivElement,
                                    description: HTMLDivElement) {
        title.innerHTML = userImage.title
        author.innerHTML = userImage.author
        description.innerHTML = userImage.description
    }

    private fun Element.appendChild(vararg elements: Element) {
        elements.forEach {
            this.appendChild(it)
        }
    }
}