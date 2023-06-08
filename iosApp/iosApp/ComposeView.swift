//
//  ComposeView.swift
//  iosApp
//
//  Created by 박준기 on 2023/06/08.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
        
    }
    
    func makeUIViewController(context: Context) -> some UIViewController {
        AppKt.MainViewController()
    }
}
