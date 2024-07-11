import UIKit
import AVFoundation

class ViewController: UIViewController, UIImagePickerControllerDelegate, UINavigationControllerDelegate {

    var webSocketTask: URLSessionWebSocketTask?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // WebSocket接続の設定
        let urlSession = URLSession(configuration: .default)
        let url = URL(string: "wss://your-websocket-server-url")!
        webSocketTask = urlSession.webSocketTask(with: url)
        webSocketTask?.resume()
        
        // カメラを起動
        openCamera()
    }
    
    func openCamera() {
        if UIImagePickerController.isSourceTypeAvailable(.camera) {
            let imagePicker = UIImagePickerController()
            imagePicker.delegate = self
            imagePicker.sourceType = .camera
            present(imagePicker, animated: true, completion: nil)
        } else {
            print("カメラが利用できません")
        }
    }

    func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
        if let image = info[.originalImage] as? UIImage {
            // 画像をJPEGデータに変換
            if let imageData = image.jpegData(compressionQuality: 0.8) {
                sendImageData(imageData)
            }
        }
        picker.dismiss(animated: true, completion: nil)
    }
    
    func sendImageData(_ data: Data) {
        let message = URLSessionWebSocketTask.Message.data(data)
        webSocketTask?.send(message) { error in
            if let error = error {
                print("WebSocket送信エラー: \(error)")
            } else {
                print("画像データが送信されました")
            }
        }
    }
    
    func imagePickerControllerDidCancel(_ picker: UIImagePickerController) {
        picker.dismiss(animated: true, completion: nil)
    }
}
