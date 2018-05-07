package logic

/**
 * Created by agallo on 1/30/18.
 */

open class BrowsePresenter(val viewInput: BrowseViewInput? = null,
                           val interactorInput: BrowseInteractorInput? = null):
                            BrowseInteractorOutput, BrowseViewOutput{

    override fun didUpdate(entity: Entity) {
        viewInput?.set(BrowseViewModel(entity.browseProducts))
    }

    override fun loadData() {
        interactorInput?.loadData()
    }

}