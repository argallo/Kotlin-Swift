package logic

/**
 * Created by agallo on 2/2/18.
 */

interface BrowseViewInput {
    fun set(viewModel: BrowseViewModel)
}

interface BrowseViewOutput {
    fun loadData()
}