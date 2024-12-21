```toml
name = 'updateProduct'
method = 'PUT'
url = 'http://localhost:8181/api/v1/products/2'
sortWeight = 3000000
id = 'ca057228-c31b-4e79-900c-9bab83ed6176'

[body]
type = 'JSON'
raw = '''
{
  "productName": "iPhone 66Pro MAX",
  "productPrice": 465000.75,
  "productQuantity": 2,
  "productImage" : "iPhone.jpg"
}'''
```
