const crypto = require('crypto');
const msg = '한글';
let hash = crypto.createHash('MD5'); //사용하지 마시오. 보안 이미 파회당함 MD5
hash.update(msg);
console.log(hash.digest('hex'));
console.log('--------------------------------------');
hash = crypto.createHash('sha256');
hash.update(msg);
console.log(hash.digest('hex'));