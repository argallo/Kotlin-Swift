//
//  BrowseViewController.swift
//  SwiftKotlin
//
//  Created by Anthony Gallo on 2/2/18.
//  Copyright © 2018 Anthony Gallo. All rights reserved.
//

import Foundation
import UIKit
import nativeLibs
import BrickKit

class BrowseViewController: BrickViewController, NativeLibsBrowseViewInput {
    var viewModel: NativeLibsBrowseViewModel = NativeLibsBrowseViewModel(products: [])
    var output: NativeLibsBrowseViewOutput?
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        self.output?.loadData()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.backgroundColor = UIColor.white
        
        let section = BrickSection(bricks: [
            LabelBrick("BROWSE", size: BrickSize(width: .ratio(ratio: 1 / 2), height: .fixed(size: 50)), dataSource: self)])
        section.repeatCountDataSource = self
        self.setSection(section)
    }
 
    func set(viewModel: NativeLibsBrowseViewModel) {
        self.viewModel = viewModel
        //print(viewModel.products as! [NativeLibsBrowseProduct])
        self.brickCollectionView.invalidateRepeatCounts()
    }
}

extension BrowseViewController: BrickRepeatCountDataSource {
    func repeatCount(for identifier: String, with collectionIndex: Int, collectionIdentifier: String) -> Int {
        return identifier == "BROWSE" ? self.viewModel.products.count : 1
    }
}

extension BrowseViewController: LabelBrickCellDataSource {
    func configureLabelBrickCell(_ cell: LabelBrickCell) {
        guard let vm = self.viewModel.products as? [NativeLibsBrowseProduct] else { return }
        cell.label.text = vm[cell.index].name
    }
}
