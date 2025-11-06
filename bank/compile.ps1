Write-Host "Compiling Java files..." -ForegroundColor Green
javac -d . bank/*.java 

if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilation successful!" -ForegroundColor Green
    Write-Host "Running tut17 Package..." -ForegroundColor Yellow
    java bank.tut17
} else {
    Write-Host "Compilation failed!" -ForegroundColor Red
}
