//
//  ViewController.swift
//  ios-app
//
//  Created by Andrey Kovalev on 20.01.2022.
//

import MultiPlatformLibrary
import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        createVM()
    }

    func createVM() {
        let vm: AuthViewModel = AuthViewModel(eventsDispatcher: EventsDispatcher(listener: self))
        vm.onAuthPressed()
    }
}

