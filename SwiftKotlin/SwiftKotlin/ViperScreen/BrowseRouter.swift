//
//  BrowseRouter.swift
//  SwiftKotlin
//
//  Created by Anthony Gallo on 2/2/18.
//  Copyright © 2018 Anthony Gallo. All rights reserved.
//

import Foundation
import UIKit
import nativeLibs

class BrowseRouter: NativeLibsBrowseRouting {

    var interactorInput: NativeLibsBrowseInteractorInput?
    var navigationController: UINavigationController?
    var repository: NativeLibsBrowseRepository
    var viewController: BrowseViewController?
    
    init(repository: NativeLibsBrowseRepository) {
        self.repository = repository
        let interactor = NativeLibsBrowseInteractor(repository: repository)
        //interactor.router = self
        self.interactorInput = interactor
        let viewController = BrowseViewController()
        let presenter = NativeLibsBrowsePresenter(viewInput: viewController, interactorInput: interactor)
        interactor.output = presenter
        viewController.output = presenter
        self.viewController = viewController
    }
    
    func present() {
        
    }
    
}
