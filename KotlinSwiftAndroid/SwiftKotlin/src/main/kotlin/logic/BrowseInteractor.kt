package logic

/**
 * Created by agallo on 1/30/18.
 */


interface BrowseInteractorInput {
    fun loadData()
    fun fireEntityChanged(didDataChange: Boolean)
}

interface BrowseInteractorOutput {
    fun didUpdate(entity: Entity)
}

open class BrowseInteractor(val repository: BrowseRepository) : BrowseInteractorOutput, BrowseInteractorInput {
    val urlString = "https://www.wayfair.com/v/category/display?&" +
            "category_id=413892&curpage=1&itemsperpage=24&_show_summary=true&_format=json"
    var entity = Entity(arrayListOf())
    var output: BrowseInteractorOutput? = null
    var router: BrowseRouting? = null

    override fun loadData() {
        repository.loadData(urlString) { browseProducts ->
            entity = Entity(browseProducts)
            fireEntityChanged(true)
        }
    }

    override fun fireEntityChanged(didDataChange: Boolean) {
        didUpdate(entity)
    }

    override fun didUpdate(entity: Entity) {
        output?.didUpdate(entity)
    }

}

data class Entity(val browseProducts: ArrayList<BrowseProduct>)