//
//  ViewController.swift
//  SwiftKotlin
//
//  Created by Anthony Gallo on 1/29/18.
//  Copyright © 2018 Anthony Gallo. All rights reserved.
//

import UIKit
import nativeLibs

class ViewController: UIViewController {
    
    typealias Unit = (String) -> NativeLibsStdlibUnit

  
    @IBOutlet weak var browseButton: UIButton!
    @IBOutlet weak var welcomeText: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
//        // Do any additional setup after loading the view, typically from a nib.
        
//        guard let word = words.getWords() else { return }
//        welcomeText.text = word

        let words = NativeLibsWords()
        typealias Unit = (String) -> NativeLibsStdlibUnit
        let completion: (String) -> NativeLibsStdlibUnit = { Unit in
            print(Unit)
            return NativeLibsStdlibUnit()
        }
        words.testing(completionHandler: completion)
        
//        words.test()
 
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func displayBrowse(_ sender: Any) {
        let browseRouter = BrowseRouter(repository: NativeLibsBrowseRepository())
        self.present(browseRouter.viewController!, animated: true, completion: nil)
    }
}

